package DZ_8_fin;

class buffer_class {
        private MyWindow win;


        public buffer_class(MyWindow some_win) {
            this.win = some_win;
        }
        public void buffer_Method(String string){
            win.setTextInToLabel(string);
        }

    }

