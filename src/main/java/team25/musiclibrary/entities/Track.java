package team25.musiclibrary.entities;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "track")
@Table(name = "track", schema = "music_store", catalog = "")
@XStreamAlias("Track")
public class Track implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XStreamOmitField
    private int id;
    @Column(name = "name")
    @XStreamAlias("name")
    private String name;
    @Column(name = "album")
    @XStreamAlias("album")
    private String album;
    @Column(name = "duration")
    @XStreamAlias("duration")
    private LocalTime duration;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "artist_track",
            joinColumns = { @JoinColumn(name = "track_id") },
            inverseJoinColumns = { @JoinColumn(name = "artist_id") })
    @XStreamOmitField
    private List<Artist> artists = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "genre_track",
            joinColumns = { @JoinColumn(name = "track_id") },
            inverseJoinColumns = { @JoinColumn(name = "genre_id") })
    @XStreamOmitField
    private List<Genre> genres = new ArrayList<>();

    @Transient
    @XStreamAlias("Artists")
    private List<ArtistTmp> artistTmps;

    @Transient
    @XStreamAlias("Genres")
    private List<GenreTmp> genreTmps;

    public List<ArtistTmp> getArtistTmps() {
        return artistTmps;
    }

    public void setArtistTmps(List<ArtistTmp> artistTmps) {
        this.artistTmps = artistTmps;
    }

    public List<GenreTmp> getGenreTmps() {
        return genreTmps;
    }

    public void setGenreTmps(List<GenreTmp> genreTmps) {
        this.genreTmps = genreTmps;
    }

    public Track() {
    }

    public Track(String name, String album, LocalTime duration) {
        this.name = name;
        this.album = album;
        this.duration = duration;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getDuration() {
        if (duration != null){
            return duration.format(DateTimeFormatter.ISO_LOCAL_TIME);
        }
        else {
            return "";
        }
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public void initToDownload(){
        genreTmps = new ArrayList<>();
        artistTmps = new ArrayList<>();
        for (Artist artist : artists) {
            ArtistTmp artistTmp = new ArtistTmp();
            artistTmp.setName(artist.getName());
            artistTmps.add(artistTmp);
        }
        for (Genre genre : genres) {
            GenreTmp  genreTmp = new GenreTmp(genre.getName());
            genreTmps.add(genreTmp);
        }
    }
}
