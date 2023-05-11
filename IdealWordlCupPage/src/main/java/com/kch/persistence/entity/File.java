package com.kch.persistence.entity;

import com.kch.persistence.BaseEntity;
import jakarta.persistence.*;
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

    @OneToOne(fetch = FetchType.LAZY)
    private Game game;

    @OneToOne(fetch = FetchType.LAZY)
    private GameElement gameElement;


    @Builder
    private File(String fileName, String filePath, int fileSize, String fileExtension) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.fileExtension = fileExtension;
    }
}
