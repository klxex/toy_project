package com.hwan.yaksa.domain.user;

import com.hwan.yaksa.domain.TimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name,String email,Role role){
        this.name=name;
        this.email=email;
        this.role=role;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

    public User update(String name) {
        this.name = name;
        return this;
    }





}
