package com.mrjuoss.dicoding.liverpoolplayer;

import java.util.ArrayList;

public class PlayerData {
    public static String[][] data = new String[][] {
            {"GOALKEEPERS", "Alisson Becker", "13", "https://d3j2s6hdd6a7rg.cloudfront.net/v2/uploads/media/misc/0001/70/thumb_69945_misc_general_500.jpeg", "Alisson 1."},
            {"GOALKEEPERS", "Simon Mignolet", "22", "https://d3j2s6hdd6a7rg.cloudfront.net/v2/uploads/media/misc/0001/70/thumb_69999_misc_general_500.jpeg", "the club's coaching staff."},
            {"GOALKEEPERS", "Caoimhin Kelleher", "62", "https://d3j2s6hdd6a7rg.cloudfront.net/v2/uploads/media/misc/0001/70/thumb_69996_misc_general_500.jpeg", "Liverpool secured the."},
            {"DEFENDERS", "Virgil van Dijk", "04", "https://d3j2s6hdd6a7rg.cloudfront.net/v2/uploads/media/misc/0001/71/thumb_70012_misc_general_500.jpeg", "Virgil van Dijk Year by his peers and also."},
            {"DEFENDERS", "Dejan Lovren", "06", "https://d3j2s6hdd6a7rg.cloudfront.net/v2/uploads/media/misc/0001/72/thumb_71690_misc_general_500.jpeg", "Liverpool continued their recruitment drive e to prominence. "}
    };

    public static ArrayList<Player> getListData() {
        Player player = null;
        ArrayList<Player> list = new ArrayList<>();
        for (String[] aData : data) {
            player = new Player();
            player.setGroup(aData[0]);
            player.setName(aData[1]);
            player.setNumber(aData[2]);
            player.setPhoto(aData[3]);
            player.setDescription(aData[4]);

            list.add(player);
        }

        return list;
    }
}
