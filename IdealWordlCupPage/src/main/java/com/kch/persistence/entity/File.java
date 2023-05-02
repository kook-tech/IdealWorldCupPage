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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(
        name = "id",
        column = @Column(name = "file_id")
)
public class File extends BaseEntity {
    @Column(name="file_name", nullable = false, length = 50)
    private String fileName;

    @Column(name ="file_path", nullable = false, length = 255)
    private String filePath;

    @Column(name="fileSize", nullable = false)
    private int fileSize;

    @Column(name="file_extension", nullable = false, length = 20)
    private String fileExtension;

    @Builder
    private File(String fileName, String filePath, int fileSize, String fileExtension) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.fileExtension = fileExtension;
    }
}
