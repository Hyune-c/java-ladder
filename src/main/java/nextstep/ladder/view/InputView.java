package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import nextstep.ladder.view.exception.InvalidParseIntegerException;

public class InputView {

    private static final Function<String, String> playerNamesAssist = string ->
        (string.isEmpty()) ? "pobi,honux,crong,jk,hyune" : string;

    private static final Function<String, String> ladderHeightAssist = string ->
        (string.isEmpty()) ? "10" : string;

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputPlayerName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        input = playerNamesAssist.apply(input);

        return Arrays.stream(input.split(","))
            .collect(Collectors.toList());
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = scanner.nextLine();
        input = ladderHeightAssist.apply(input);

        return parseInteger(input);
    }

    private static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new InvalidParseIntegerException();
        }
    }
}
