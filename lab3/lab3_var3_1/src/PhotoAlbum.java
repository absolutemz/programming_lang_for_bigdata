import java.util.ArrayList;

public class PhotoAlbum {
    private String name;
    private ArrayList<Photograph> photos;

    public PhotoAlbum(String name) {
        this.name = name;
        this.photos = new ArrayList<Photograph>();
    }

    public void addPhoto(Photograph photo) {
        photos.add(photo);
    }

    public int getNumberOfPhotos() {
        return photos.size();
    }

    @Override
    public String toString() {
        return "PhotoAlbum{" +
                "name='" + name + '\'' +
                ", photos=" + photos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoAlbum that = (PhotoAlbum) o;
        if (!name.equals(that.name)) return false;
        return photos.equals(that.photos);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + photos.hashCode();
        return result;
    }
}

