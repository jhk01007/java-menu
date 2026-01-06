package menu.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static menu.util.ErrorMessage.COACH_NAME_LENGTH_ERROR;
import static menu.util.ErrorMessage.COACH_NUM_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputParserTest {

    @Test
    @DisplayName("문자열 형태의 코치 이름을 리스트로 변환")
    public void parseCoachName_success() throws Exception {
        // given
        String strCoachName = "토미,제임스,포코";

        // when
        List<String> coachNames = InputParser.parseCoachName(strCoachName);

        // then
        assertThat(coachNames).hasSize(3);
        assertThat(coachNames).containsExactlyInAnyOrder("토미", "제임스", "포코");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "포코",
            "토미,제임스,포코,토니,마이크,존박",
    })
    @DisplayName("문자열 형태의 코치 이름을 리스트로 변환할 때 코치가 최소 2명, 최대 5명이 아니면 에러가 발생한다.")
    public void parseCoachName_fail1(String strCoachName) throws Exception {
        // when // then
        assertThatThrownBy(() -> InputParser.parseCoachName(strCoachName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(COACH_NUM_ERROR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "토미,제임스,톰",
            "토미,제임스,알렉산드로"
    })
    @DisplayName("문자열 형태의 코치 이름을 리스트로 변환할 때 코치 이름의 길이가 최소 2, 최대 4가 아니면 에러가 발생한다.")
    public void parseCoachName_fail2(String strCoachName) throws Exception {
        System.out.println(strCoachName);
        // when // then
        assertThatThrownBy(() -> InputParser.parseCoachName(strCoachName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(COACH_NAME_LENGTH_ERROR.getMessage());
    }
}