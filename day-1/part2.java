void main() {
    int position = 50;
    int password = 0;
    try {
        List<String> turns = Files.readAllLines(Paths.get("input"));
        for (String turn : turns) {
            char direction = turn.charAt(0);
            int distance = Integer.parseInt(turn.substring(1));

            // complete turns always go past 0
            password += distance / 100;
            distance %= 100;
            
            if (direction == 'L') {
                if (position != 0 && position <= distance) {
                    password++;
                }
                position -= distance;
            } else {
                if (position != 0 && 100 - position <= distance) {
                    password++;
                }
                position += distance;
            }
            position %= 100;
            if (position < 0) {
                position += 100;
            }
        }
        IO.println(password);
    } catch (IOException e) {
        IO.println("error");
    }
}
