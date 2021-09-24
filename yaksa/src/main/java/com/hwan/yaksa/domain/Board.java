package com.hwan.yaksa.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String writer;
    private String boardContent;
    private LocalDateTime registerTime;
    private int readCount=0;
}
