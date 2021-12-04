package com.developia.goodreads.dao.entity;

import com.developia.goodreads.model.enums.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "genre")
    private String genre;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "left_in_stock")
    private Integer leftInStock;

    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "page_count")
    private Integer pageCount;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private BookStatus status;

    @Column(name = "language")
    private String language;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "image")
    private String image;

    @OneToMany
    // bunu vermediyimiz teqdirde hibernate ortada 3-cu cedvel olmagini isteyir books_reviews, olmadigina gore error aliriq
    @JoinColumn(name = "book_id") // hibernate bilir ki join olunacaq sutun book_id-dir
    private List<BookReviewsEntity> reviews = new ArrayList<>();
}
