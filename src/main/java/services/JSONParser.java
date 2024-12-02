package services;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Playlist;

/**
 * This JsonParser will help parse through the response.
 */
public class JSONParser {

    /**
     * Helps us solve response.
     * @param jsonResponse gives us the argument.
     * @return the playlist we want.
     * @throws RuntimeException if something goes wrong.
     */
    public Playlist parse(String jsonResponse) {
        //        final String jsonResponse = "{\n"
        //                + "  \"seeds\": [\n"
        //                + "    {\n"
        //                + "      \"afterFilteringSize\": 0,\n"
        //                + "      \"afterRelinkingSize\": 0,\n"
        //                + "      \"href\": \"string\",\n"
        //                + "      \"id\": \"string\",\n"
        //                + "      \"initialPoolSize\": 0,\n"
        //                + "      \"type\": \"string\"\n"
        //                + "    }\n"
        //                + "  ],\n"
        //                + "  \"tracks\": [\n"
        //                + "    {\n"
        //                + "      \"album\": {\n"
        //                + "        \"album_type\": \"compilation\",\n"
        //                + "        \"total_tracks\": 9,\n"
        //                + "        \"available_markets\": [\"CA\", \"BR\", \"IT\"],\n"
        //                + "        \"external_urls\": {\n"
        //                + "          \"spotify\": \"string\"\n"
        //                + "        },\n"
        //                + "        \"href\": \"string\",\n"
        //                + "        \"id\": \"2up3OPMp9Tb4dAKM2erWXQ\",\n"
        //                + "        \"images\": [\n"
        //                + "          {\n"
        //                + "            \"url\": \"https://i.scdn.co/image/ab67616d00001e02ff9ca10b55ce82ae553c8228\",\n"
        //                + "            \"height\": 300,\n"
        //                + "            \"width\": 300\n"
        //                + "          }\n"
        //                + "        ],\n"
        //                + "        \"name\": \"string\",\n"
        //                + "        \"release_date\": \"1981-12\",\n"
        //                + "        \"release_date_precision\": \"year\",\n"
        //                + "        \"restrictions\": {\n"
        //                + "          \"reason\": \"market\"\n"
        //                + "        },\n"
        //                + "        \"type\": \"album\",\n"
        //                + "        \"uri\": \"spotify:album:2up3OPMp9Tb4dAKM2erWXQ\",\n"
        //                + "        \"artists\": [\n"
        //                + "          {\n"
        //                + "            \"external_urls\": {\n"
        //                + "              \"spotify\": \"string\"\n"
        //                + "            },\n"
        //                + "            \"href\": \"string\",\n"
        //                + "            \"id\": \"string\",\n"
        //                + "            \"name\": \"string\",\n"
        //                + "            \"type\": \"artist\",\n"
        //                + "            \"uri\": \"string\"\n"
        //                + "          }\n"
        //                + "        ]\n"
        //                + "      },\n"
        //                + "      \"artists\": [\n"
        //                + "        {\n"
        //                + "          \"external_urls\": {\n"
        //                + "            \"spotify\": \"string\"\n"
        //                + "          },\n"
        //                + "          \"href\": \"string\",\n"
        //                + "          \"id\": \"string\",\n"
        //                + "          \"name\": \"string\",\n"
        //                + "          \"type\": \"artist\",\n"
        //                + "          \"uri\": \"string\"\n"
        //                + "        }\n"
        //                + "      ],\n"
        //                + "      \"available_markets\": [\"string\"],\n"
        //                + "      \"disc_number\": 0,\n"
        //                + "      \"duration_ms\": 0,\n"
        //                + "      \"explicit\": false,\n"
        //                + "      \"external_ids\": {\n"
        //                + "        \"isrc\": \"string\",\n"
        //                + "        \"ean\": \"string\",\n"
        //                + "        \"upc\": \"string\"\n"
        //                + "      },\n"
        //                + "      \"external_urls\": {\n"
        //                + "        \"spotify\": \"string\"\n"
        //                + "      },\n"
        //                + "      \"href\": \"string\",\n"
        //                + "      \"id\": \"string\",\n"
        //                + "      \"is_playable\": false,\n"
        //                + "      \"linked_from\": {},\n"
        //                + "      \"restrictions\": {\n"
        //                + "        \"reason\": \"string\"\n"
        //                + "      },\n"
        //                + "      \"name\": \"string\",\n"
        //                + "      \"popularity\": 0,\n"
        //                + "      \"preview_url\": \"string\",\n"
        //                + "      \"track_number\": 0,\n"
        //                + "      \"type\": \"track\",\n"
        //                + "      \"uri\": \"string\",\n"
        //                + "      \"is_local\": false\n"
        //                + "    }\n"
        //                + "  ]\n"
        //                + "}";

        final Playlist playlist;

        try {
            // Initialize Jackson ObjectMapper
            final ObjectMapper objectMapper = new ObjectMapper();

            // Parse the JSON into a Playlist object
            playlist = objectMapper.readValue(jsonResponse, Playlist.class);

            // Output the parsed Playlist data
            System.out.println("Playlist ID: " + playlist.getId());
            System.out.println("Playlist Name: " + playlist.getName());
            System.out.println("Number of Tracks: " + playlist.getTracks().size());

            // Output track details
            //            for (Track track : playlist.getTracks()) {
            //                System.out.println("Track Name: " + track.getName());
            //                System.out.println("Album Name: " + track.getAlbumName());
            //                System.out.println("Album ID: " + track.getAlbumId());
            //                System.out.println("Track ID: " + track.getId());
            //                System.out.println("Available Markets: " + String.join(", ", track.getAvailableMarkets()));
            //            }
            // Note: JSONParser will probably fail lmao.
        }
        catch (IOException ex) {
            throw new RuntimeException("Help me, JSONParser failed.", ex);
        }

        return playlist;
    }
}
