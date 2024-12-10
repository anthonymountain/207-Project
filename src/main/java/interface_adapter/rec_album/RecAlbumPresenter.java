package interface_adapter.rec_album;

public class RecAlbumPresenter {
}

    @Override
    public void prepareSuccessView(RecAlbumOutputData outputData) {
        final JDialog dialog = new JDialog(new JFrame(),
                "Album Recommendation", true);
        final RecAlbumView recAlbumView = new RecAlbumView();
        recAlbumView.setAlbum(outputData.getAlbum());
        dialog.getContentPane().add(recAlbumView);
        dialog.pack();
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    @Override
    public void prepareFailView(RecAlbumOutputData outputData) {
        System.err.println("Error: " + outputData.getMessage());
    }
}