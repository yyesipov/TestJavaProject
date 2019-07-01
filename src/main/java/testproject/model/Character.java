package testproject.model;

import java.io.Serializable;
import javax.persistence.*;


    @Entity
    @Table(name = "characters")
    public class Character implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "name")
        private String name;

        @Column(name = "status")
        private String status;

        @Column(name = "species")
        private String species;

       @Column (name = "gender")
       private String gender;

        @Column (name = "image")
        private String image;

        @Column (name = "url")
        private String url;


        public Character() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSpecies() {
            return species;
        }

        public void setSpecies(String species) {
            this.species = species;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "Character{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", status='" + status + '\'' +
                    ", species='" + species + '\'' +
                    ", gender='" + gender + '\'' +
                    ", image='" + image + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

