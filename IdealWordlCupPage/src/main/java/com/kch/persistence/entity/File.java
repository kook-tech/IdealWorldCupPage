package com.kch.persistence.entity;

import com.kch.persistence.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "TBL_FILES")
@ToString
@Getter
@Builder
@NoArgsConstructor
@AttributeOverride(
        name = "id",
        column = @Column(name = "file_id")
)
public class File extends BaseEntity {
    @Column(name="file_name")
    private String fileName;

    @Column(name ="file_path")
    private String filePath;

    @Column(name="fileSize")
    private int fileSize;

    @Column(name="file_extension")
    private String fileExtension;

    @Builder
    public File(String fileName, String filePath, int fileSize, String fileExtension) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.fileExtension = fileExtension;
    }
}
