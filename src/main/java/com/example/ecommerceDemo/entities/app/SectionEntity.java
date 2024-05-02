package com.example.ecommerceDemo.entities.app;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class SectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sectionId;

    private String sectionName;

    @OneToMany(mappedBy = "sectionEntity", cascade = CascadeType.ALL)
    private List<TaskEntity> tasks;

    private SectionEntity(Builder builder) {
        setSectionId(builder.sectionId);
        setSectionName(builder.sectionName);
        setTasks(builder.tasks);
    }


    public static final class Builder {
        private Long sectionId;
        private String sectionName;
        private List<TaskEntity> tasks;

        public Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder sectionId(Long val) {
            sectionId = val;
            return this;
        }

        public Builder sectionName(String val) {
            sectionName = val;
            return this;
        }

        public Builder tasks(List<TaskEntity> val) {
            tasks = val;
            return this;
        }

        public SectionEntity build() {
            return new SectionEntity(this);
        }
    }
}
