void main() {
    try {
        long sum = 0;
        List<String> lines = Files.readAllLines(Paths.get("input"));
        String[] ranges = lines.get(0).split(",");
        for (String range : ranges) {
            String[] rangeBoundaries = range.split("-");
            long start = Long.parseLong(rangeBoundaries[0]);
            long end = Long.parseLong(rangeBoundaries[1]);
            for (long i = start; i <= end; i++) {
                String number = Long.toString(i);
                if (number.length() % 2 == 1) {
                    continue;
                }
                boolean invalid = true;
                for (int j = 0, k = number.length() / 2; k < number.length(); j++, k++) {
                    if (number.charAt(j) != number.charAt(k)) {
                        invalid = false;
                    }
                }
                if (invalid) {
                    sum += i;
                }
            } 
        }
        IO.println(sum);
    } catch (IOException e) {
        IO.println("error");
    }
}
