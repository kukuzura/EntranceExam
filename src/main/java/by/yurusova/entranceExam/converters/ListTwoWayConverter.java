package by.yurusova.entranceExam.converters;

import java.util.List;

/**
 * Simple interface of two way list converter.
 *
 * @param <S> first type.
 * @param <T> second type.
 * @author Yuliya Yurusava <y.yurusava@sam-solutions.com>
 * @package by.yurusova.entranceExam.converters
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */
public interface ListTwoWayConverter<S, T> {
    /**
     * Method converts list of o T type to S type.
     *
     * @param source list of T to be convert.
     * @return list of S type.
     */
    List<T> convertList(List<S> source);

    /**
     * Method converts list of  to T type.
     *
     * @param target list of S to be convert.
     * @return list of T type.
     */
    List<S> convertBackList(List<T> target);

}
