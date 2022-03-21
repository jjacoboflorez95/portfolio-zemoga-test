package co.com.zemoga.portafolio.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "portfolio")
public class PortfolioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idportfolio")
    private int idportfolio;

    @Column(name="description")
    private String description;

    @Column(name="experience_summary")
    private String experienceSummary;

    @Column(name="id")
    private int id;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="last_names")
    private String lastNames;

    @Column(name="names")
    private String names;

    @Column(name="tittle")
    private String tittle;

    @Column(name="twitter_user_id")
    private String twitterUserId;

    @Column(name="twitter_user_name")
    private String twitterUserName;

    @Column(name="user_id")
    private String userId;

    @Column(name="address")
    private String address;

    @Column(name="email")
    private String email;

    @Column(name="experience")
    private String experience;

    @Column(name="image_path")
    private String imagePath;

    @Column(name="name")
    private String name;

    @Column(name="phone")
    private String phone;

    @Column(name="twitter_user")
    private String twitterUser;

    @Column(name="zip_code")
    private String zipCode;

    @Column(name="title")
    private String title;
}
