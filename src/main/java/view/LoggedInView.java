package view;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interface_adapter.loggedin.LoggedInState;
import interface_adapter.loggedin.LoggedInViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.rec_artist.RecArtistController;
import interface_adapter.rec_genre.RecGenreController;
import interface_adapter.rec_playlist.RecPlaylistController;
import interface_adapter.rec_song.RecSongController;

/**
 * The View for the LoggedIn Use Case.
 */
public class LoggedInView extends JPanel implements java.beans.PropertyChangeListener {

    private static final String FONT = "Futura";
    private static final int TWENTY = 20;
    private static final int TEN = 10;

    private static final Color DARK_BACKGROUND = new Color(24, 24, 32);
    private static final Color SPOTIFY_GREEN = new Color(30, 215, 96);
    private static final Color BUTTON_TEXT_COLOR = Color.WHITE;

    private static final Font HEADER_FONT = new Font(FONT, Font.BOLD, 18);
    private static final Font BUTTON_FONT = new Font(FONT, Font.PLAIN, 16);
    private static final Font LABEL_FONT = new Font(FONT, Font.PLAIN, 14);

    private final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private final JLabel username;
    private JButton logOut;
    private JButton recArtist;
    private JButton recPlaylist;
    private JButton recSong;
    private JButton recGenre;
    private final ViewBuilder viewBuilder;

    private LogoutController logoutController;
    private RecPlaylistController recPlaylistController;
    private RecArtistController recArtistController;
    private RecSongController recSongController;
    private RecGenreController recGenreController;

    public LoggedInView(LoggedInViewModel loggedInViewModel) {
        this.loggedInViewModel = loggedInViewModel;
        loggedInViewModel.addPropertyChangeListener(this);

        setupPanelLayout();

        username = setupLabels();

        viewBuilder = new ViewBuilder();
        viewBuilder.addLabel("Currently logged in: ")
                .addButton("recSong", "Recommend Song")
                .addButton("recArtist", "Recommend Artist")
                .addButton("recGenre", "Recommend Genre")
                .addButton("recPlaylist", "Recommend Playlist")
                .addButton("logout", "Log Out")
                .setViewName(viewName);

        recSong = viewBuilder.getButton("recSong");
        recGenre = viewBuilder.getButton("recGenre");
        recArtist = viewBuilder.getButton("recArtist");
        recPlaylist = viewBuilder.getButton("recPlaylist");
        logOut = viewBuilder.getButton("logout");

        this.add(Box.createRigidArea(new Dimension(0, TEN)));
        this.add(username);
        this.add(viewBuilder);
        this.add(Box.createRigidArea(new Dimension(0, TWENTY)));
        initializeButtonActions(loggedInViewModel);
    }

    private void setupPanelLayout() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(DARK_BACKGROUND);
        this.setBorder(BorderFactory.createEmptyBorder(TWENTY, TWENTY, TWENTY, TWENTY));
    }

    private JLabel setupLabels() {
        final JLabel usernameInfo = new JLabel("Currently logged in:");
        usernameInfo.setFont(LABEL_FONT);
        usernameInfo.setForeground(BUTTON_TEXT_COLOR);
        usernameInfo.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel usernameLabel = new JLabel();
        usernameLabel.setFont(HEADER_FONT);
        usernameLabel.setForeground(SPOTIFY_GREEN);
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(usernameInfo);
        return usernameLabel;
    }

    private void initializeButtonActions(LoggedInViewModel viewModel) {
        logOut.addActionListener(evt -> handleLogoutAction(viewModel));
        recGenre.addActionListener(evt -> openGenreRecommendationDialog());
        recSong.addActionListener(evt -> openSongRecommendationDialog());
        recArtist.addActionListener(evt -> openArtistRecommendationDialog());
        recPlaylist.addActionListener(evt -> openPlaylistRecommendationDialog());
    }

    private void handleLogoutAction(LoggedInViewModel viewModel) {
        final LoggedInState currentState = viewModel.getState();
        logoutController.execute(currentState.getUsername());
    }

    private void openGenreRecommendationDialog() {
        recGenreController.execute();
    }

    private void openSongRecommendationDialog() {
        recSongController.execute(null, null, 0, null, null);
    }

    private void openArtistRecommendationDialog() {
        recArtistController.execute();
    }

    private void openPlaylistRecommendationDialog() {
        recPlaylistController.execute();
    }

    @Override
    public void propertyChange(java.beans.PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            username.setText("Currently logged in as: " + state.getUsername());
        }
        else if ("password".equals(evt.getPropertyName())) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            JOptionPane.showMessageDialog(null, "Password updated for " + state.getUsername());
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }

    public void setRecPlaylistController(RecPlaylistController recPlaylistController) {
        this.recPlaylistController = recPlaylistController;
    }

    public void setRecSongController(RecSongController recSongController) {
        this.recSongController = recSongController;
    }

    public void setRecArtistController(RecArtistController recArtistController) {
        this.recArtistController = recArtistController;
    }

    public void setRecGenreController(RecGenreController recGenreController) {
        this.recGenreController = recGenreController;
    }
}
