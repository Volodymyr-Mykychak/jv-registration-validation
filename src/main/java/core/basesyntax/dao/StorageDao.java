package core.basesyntax.dao;

import core.basesyntax.model.User;
/**
 * Інтерфейс {@code StorageDao} визначає методи для роботи з сховищем користувачів.
 */
public interface StorageDao {
    /**
     * Додає користувача до сховища.
     *
     * @param user користувач, який буде доданий до сховища
     * @return доданий користувач
     */
    User add(User user);
    /**
     * Отримує користувача з сховища за його логіном.
     *
     * @param login логін користувача
     * @return користувач з вказаним логіном або null, якщо користувач не знайдений
     */
    User get(String login);
}
