package com.rb.ppm.core.services;

import com.rb.ppm.application.dto.InvoiceDetail;
import com.rb.ppm.core.repository.InvoiceRepository;
import com.rb.ppm.application.dto.Invoice;
import com.rb.ppm.core.domain.InvoiceEntity;
import com.rb.ppm.core.mappers.InvoiceMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

      @Autowired
      InvoiceRepository invoiceRepository;


      public Invoice createInvoice(Invoice invoice){
          InvoiceEntity invoiceEntity = InvoiceMapper.INSTANCE.toEntity(invoice);
          InvoiceEntity invoiceEntitySave = invoiceRepository.save(invoiceEntity);
          invoice.setId(invoiceEntitySave.getId());
          return  invoice;
      }

      @Transactional
      public Invoice getInvoiceById(Long id){
          Optional<InvoiceEntity> invoiceOpt= invoiceRepository.findById(id);
          Invoice invoice = null;
          if(invoiceOpt.isPresent()){
            invoice = InvoiceMapper.INSTANCE.toDTO(invoiceOpt.get());
          }
          return invoice;
      }


      @Transactional
      public List<Invoice> getAllInvoice(){
          return invoiceRepository.findAll().stream().map(InvoiceMapper.INSTANCE::toDTO).toList();
      }


}
