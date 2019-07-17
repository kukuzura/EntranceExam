package by.yurusova.entranceExam.converters;

/**
 * Simple interface of two way converter.
 *
 * @param <S> first type.
 * @param <T> second type.
 * @author Yuliya Yurusava <y.yurusava@sam-solutions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public interface TwoWayConverter<S, T> {

    /**
     * Method converts from S type to T.
     *
     * @param source object of S type to be convert.
     * @return object of T type.
     */
    T convert(S source);

    /**
     * Method converts from T type to S.
     *
     * @param target object of T type to be convert.
     * @return object of S type.
     */
    S convertBack(T target);

}