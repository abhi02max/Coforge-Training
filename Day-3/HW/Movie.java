public class Movie {
    private String movieName;
    private String director;
    private double rating;

    public Movie() {
    }

    public Movie(String movieName, String director, double rating) {
        this.movieName = movieName;
        this.director = director;
        this.rating = rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie [Movie Name=" + movieName + ", Director=" + director + ", Rating=" + rating + "]";
    }
}