package com.scm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; // Import this for the @Id annotation
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SocialLinks {

    @Id // This annotation is required to mark the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String link;
    private String title;

    @ManyToOne
    private Contact contact;
}
