package com.example.MovieList.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is the entity class for table MOVIE_DATA
 */
@Entity
@Table(name = "MOVIE_DATA")
public class FileDataEntity {
    @Id
    @Column(nullable=true, name="imdb_title_id")
    private String imdb_title_id;

    @Column(nullable=true,name="title",columnDefinition = "varchar(512)")
    private String title;

    @Column(nullable=true,name="original_title",columnDefinition = "varchar(512)")
    private String original_title;

    @Column(nullable=true,name="year")
    private String year;

    @Column(nullable=true,name="date_published")
    private String date_published;

    @Column(nullable=true,name="genre",columnDefinition = "varchar(512)")
    private String genre;

    @Column(nullable=true,name="duration")
    private String duration;

    @Column(nullable=true,name="country")
    private String country;

    @Column(nullable=true,name="language",columnDefinition = "varchar(512)")
    private String language;

    @Column(nullable=true,name="director",columnDefinition = "varchar(512)")
    private String director;

    @Column(nullable=true,name="writer",columnDefinition = "varchar(512)")
    private String writer;

    @Column(nullable=true,name="production_company",columnDefinition = "varchar(512)")
    private String production_company;

    @Column(nullable=true,name="actors",columnDefinition = "varchar(512)")
    private String actors;

    @Column(nullable=true,name="description",columnDefinition = "varchar(512)")
    private String description;

    @Column(nullable=true,name="avg_vote")
    private String avg_vote;

    @Column(nullable=true,name="votes")
    private String votes;

    @Column(nullable=true,name="budget")
    private Integer budget;

    @Column(nullable=true,name="usa_gross_income")
    private String usa_gross_income;

    @Column(nullable=true,name="worldwide_gross_company")
    private String worldwide_gross_company;

    @Column(nullable=true,name="metascore")
    private String metascore;

    @Column(nullable=true,name="reviews_from_users")
    private Integer reviews_from_users;

    @Column(nullable=true,name="reviews_from_critics")
    private String reviews_from_critics;

    public String getImdb_title_id() {
        return imdb_title_id;
    }

    public void setImdb_title_id(String imdb_title_id) {
        this.imdb_title_id = imdb_title_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getProduction_company() {
        return production_company;
    }

    public void setProduction_company(String production_company) {
        this.production_company = production_company;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvg_vote() {
        return avg_vote;
    }

    public void setAvg_vote(String avg_vote) {
        this.avg_vote = avg_vote;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public String getUsa_gross_income() {
        return usa_gross_income;
    }

    public void setUsa_gross_income(String usa_gross_income) {
        this.usa_gross_income = usa_gross_income;
    }

    public String getWorldwide_gross_company() {
        return worldwide_gross_company;
    }

    public void setWorldwide_gross_company(String worldwide_gross_company) {
        this.worldwide_gross_company = worldwide_gross_company;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public Integer getReviews_from_users() {
        return reviews_from_users;
    }

    public void setReviews_from_users(Integer reviews_from_users) {
        this.reviews_from_users = reviews_from_users;
    }

    public String getReviews_from_critics() {
        return reviews_from_critics;
    }

    public void setReviews_from_critics(String reviews_from_critics) {
        this.reviews_from_critics = reviews_from_critics;
    }

    public FileDataEntity(String imdb_title_id, String title, String original_title, String year, String date_published, String genre, String duration, String country, String language, String director, String writer, String production_company, String actors, String description, String avg_vote, String votes, String usa_gross_income, String worldwide_gross_company, String metascore, String reviews_from_critics) {
        this.imdb_title_id = imdb_title_id;
        this.title = title;
        this.original_title = original_title;
        this.year = year;
        this.date_published = date_published;
        this.genre = genre;
        this.duration = duration;
        this.country = country;
        this.language = language;
        this.director = director;
        this.writer = writer;
        this.production_company = production_company;
        this.actors = actors;
        this.description = description;
        this.avg_vote = avg_vote;
        this.votes = votes;
        this.usa_gross_income = usa_gross_income;
        this.worldwide_gross_company = worldwide_gross_company;
        this.metascore = metascore;
        this.reviews_from_critics = reviews_from_critics;
    }

    public FileDataEntity() {

    }
}
