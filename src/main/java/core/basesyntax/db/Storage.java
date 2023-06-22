package core.basesyntax.db;

import core.basesyntax.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас {@code Storage} є сховищем для зберігання користувачів.
 * Вміст сховища доступний як статичне поле {@code people}.
 */
public class Storage {
    /**
     * Список користувачів, що зберігаються у сховищі.
     */
    public static final List<User> people = new ArrayList<>();
}
