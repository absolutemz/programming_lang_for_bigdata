public class Photograph {
    private String title;

    public Photograph(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Photograph{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photograph that = (Photograph) o;
        return title.equals(that.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    public static void main(String[] args) {
        PhotoAlbum album = new PhotoAlbum("Summer Vacation 2022");

        Photograph photo1 = new Photograph("Beach");
        Photograph photo2 = new Photograph("Mountains");
        Photograph photo3 = new Photograph("Cityscape");

        album.addPhoto(photo1);
        album.addPhoto(photo2);
        album.addPhoto(photo3);

        System.out.println("Number of photos in album: " + album.getNumberOfPhotos());
        System.out.println("Album details:\n" + album);
    }
}

