package com.example.ecommerceDemo.services.others;

import com.example.ecommerceDemo.DTO.others.DebitCardDTO;
import com.example.ecommerceDemo.entities.others.DebitCardEntity;
import com.example.ecommerceDemo.repositories.others.DebitCardRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DebitCardService {

    private final DebitCardRepository debitCardRepository;

    public DebitCardService(DebitCardRepository debitCardRepository) {
        this.debitCardRepository = debitCardRepository;
    }

    public DebitCardEntity createDebitCard(DebitCardDTO debitCardDTO) {

        DebitCardEntity newCard = toEntity(debitCardDTO);
        return debitCardRepository.save(newCard);

    }

    public boolean checkDetails(DebitCardDTO debitCardDTO) {

        Optional<DebitCardEntity> existingCardOptional =
                debitCardRepository.findByCardNumber(debitCardDTO.getCardNumber());

        if (existingCardOptional.isPresent()) {
            DebitCardEntity existingCard = existingCardOptional.get();
            System.out.println("aaaaaaaaaaa" + existingCard);
            System.out.println("_-_-_----__________-" + existingCard);

            if (!existingCard.getCardHolderName().equals(debitCardDTO.getCardHolderName())
                    || !existingCard.getCardNumber().equals(debitCardDTO.getCardNumber())
                    || !existingCard.getExpirationDate().isEqual(debitCardDTO.getExpirationDate())
                    || existingCard.getCvv() != (debitCardDTO.getCvv())) {
                throw new RuntimeException("Invalid card details");
            }
        } else {
            throw new RuntimeException("Card not found");
        }
        return true;
    }

    //-----------------------------------------------------------------------------------------------------------//

    public DebitCardDTO toDTO(DebitCardEntity debitCard) {
        DebitCardDTO dto = new DebitCardDTO();
        dto.setId(debitCard.getId());
        dto.setCardNumber(debitCard.getCardNumber());
        dto.setCardHolderName(debitCard.getCardHolderName());
        dto.setExpirationDate(debitCard.getExpirationDate());
        dto.setCvv(debitCard.getCvv());
        return dto;
    }

    public DebitCardEntity toEntity(DebitCardDTO dto) {
        DebitCardEntity debitCard = new DebitCardEntity();
        debitCard.setId(dto.getId());
        debitCard.setCardNumber(dto.getCardNumber());
        debitCard.setCardHolderName(dto.getCardHolderName());
        debitCard.setExpirationDate(dto.getExpirationDate());
        debitCard.setCvv(dto.getCvv());
        return debitCard;
    }


}
