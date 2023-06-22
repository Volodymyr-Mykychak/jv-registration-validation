package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.User;
/**
 * Клас {@code StorageDaoImpl} є реалізацією інтерфейсу {@link StorageDao}.
 * Він забезпечує роботу з сховищем користувачів.
 */
public class StorageDaoImpl implements StorageDao {
    private static Long index = 0L;
    /**
     * Додає користувача до сховища.
     *
     * @param user користувач, який буде доданий до сховища
     * @return доданий користувач
     */
    @Override
    public User add(User user) {
        user.setId(++index);
        Storage.people.add(user);
        return user;
    }
    /**
     * Отримує користувача з сховища за його логіном.
     *
     * @param login логін користувача
     * @return користувач з вказаним логіном або null, якщо користувач не знайдений
     */
    @Override
    public User get(String login) {
        for (User user : Storage.people) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
}
