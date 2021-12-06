package com.example.maru.model;

import androidx.annotation.StringRes;

import com.example.maru.R;

    public enum Room {
        Peach(R.string.peach, false),
        Mario(R.string.mario, false),
        Luigi(R.string.luigi, false),
        Donkey(R.string.donkey, false),
        Toad(R.string.toad, false),
        Yoshi(R.string.yoshi, false),
        Wario(R.string.wario, false),
        Kirby(R.string.kirby, false),
        Zelda(R.string.zelda, false),
        Link(R.string.link, false);

        private boolean isOccupied;
        private long id;

        @StringRes
        private final int mName;

        Room(@StringRes int name, boolean isOccupied) {
            mName = name;
            this.isOccupied = isOccupied;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public void setOccupied(boolean occupied) {
            isOccupied = occupied;
        }

        public int getName() {
            return mName;
        }

        public boolean isOccupied(){
        return isOccupied;
        }

}
