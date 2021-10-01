package com.hwan.yaksa.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board extends TimeEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String writer;
    private String boardContent;
    private int readCount=0;

    @Builder
    public Board(String title,String writer,String boardContent,int readCount){
        this.title=title;
        this.writer=writer;
        this.boardContent=boardContent;
        this.readCount=readCount;
    }
}
