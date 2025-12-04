void main() {
    int position = 50;
    int password = 0;
    try {
        List<String> turns = Files.readAllLines(Paths.get("input"));
        for (String turn : turns) {
            char direction = turn.charAt(0);
            int distance = Integer.parseInt(turn.substring(1));
            if (direction == 'L') {
                position -= distance;
            } else {
                position += distance;
            }
            if (position % 100 == 0) {
                password++;
            }
        }
        IO.println(password);
    } catch (IOException e) {
        IO.println("error");
    }
}
