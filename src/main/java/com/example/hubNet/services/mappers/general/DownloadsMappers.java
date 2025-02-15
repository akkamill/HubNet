package com.example.hubNet.services.mappers.general;


import com.example.hubNet.DTO.general.downloads.DownloadsDTO;
import com.example.hubNet.entities.general.users.DownloadsEntity;
import org.springframework.stereotype.Component;

@Component
public class DownloadsMappers {


    public static DownloadsDTO toDTO(DownloadsEntity entity) {
        if (entity == null) {
            return null;
        }

        DownloadsDTO dto = new DownloadsDTO();

        dto.setDownloadId(entity.getDownloadId());
        dto.setPlatforms(entity.getPlatforms());
        dto.setTotalDownloads(entity.getTotalDownloads());

        return dto;
    }

    public static DownloadsEntity toEntity(DownloadsDTO dto) {
        if (dto == null) {
            return null;
        }

        DownloadsEntity entity = new DownloadsEntity();

        entity.setDownloadId(dto.getDownloadId());
        entity.setPlatforms(dto.getPlatforms());
        entity.setTotalDownloads(dto.getTotalDownloads());

        return entity;
    }
}
