package com.blog.blog.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int numberPage;
    private String content;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    public Blog() {
    }

    public Blog(int id, String title, int numberPage, String content, Category category) {
        this.id = id;
        this.title = title;
        this.numberPage = numberPage;
        this.content = content;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
