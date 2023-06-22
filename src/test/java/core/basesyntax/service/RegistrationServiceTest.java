package core.basesyntax.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.db.Storage;
import core.basesyntax.model.User;
import core.basesyntax.service.exceptions.PasswordException;
import core.basesyntax.service.exceptions.UserRegistrationException;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Клас, що містить тести для класу RegistrationService.
 */
class RegistrationServiceTest {

    private static final int MIN_USER_AGE = 18;
    private static final String VALID_PASSWORD = "123456";
    private static final String DEFAULT_LOGIN = "login";
    private final RegistrationService registrationService = new RegistrationServiceImpl();

    /**
     * Метод, який очищає базу даних після кожного тесту.
     */
//    @AfterEach
//    void clearStorage() {
//        Storage.people.clear();
//    }

    /**
     * Метод {@code register_normalUser_ok} тестує реєстрацію нормального користувача
     * з коректними даними. Перевіряється правильність поверненого результату,
     * наявність ідентифікатора після реєстрації та стан бази даних.
     */
//    @Test
//    void register_normalUser_ok() {
//        // Створення нормального користувача з коректними даними
//        User normalUser = createUser(DEFAULT_LOGIN, VALID_PASSWORD, MIN_USER_AGE);
//        // Виклик методу реєстрації користувача
//        User registeredUser = registrationService.register(normalUser);
//        // Перевірка, що повернутий користувач є тим самим, що і вхідний
//        Assertions.assertSame(normalUser, registeredUser,
//                "register method must return same user as was supplied");
//        // Перевірка, що після реєстрації користувач має ідентифікатор
//        assertNotNull(normalUser.getId(), "User must have id after registration");
//        // Перевірка стану бази даних
//        List<User> actualDbState = new ArrayList<>();
//        actualDbState.add(normalUser);
//        assertEquals(Storage.people, actualDbState, "User must be saved in db");
//    }

    /**
     * Тест на реєстрацію декількох звичайних користувачів.
     * Перевіряє, чи користувачі були зареєстровані успішно, чи мають вони ID після реєстрації
     * та чи були користувачі збережені у базі даних.
     */
//    @Test
//    void register_fewNormalUsers_ok() {
//        // Очікуваний стан бази даних
//        List<User> expectedDbState = new ArrayList<>();
//
//        // Реєстрація кількох нормальних користувачів
//        for (int i = 0; i < 100; i++) {
//            // Створення нормального користувача з унікальними даними
//            User normalUser = createUser(DEFAULT_LOGIN + i, VALID_PASSWORD + i, MIN_USER_AGE + i);
//            // Виклик методу реєстрації користувача
//            registrationService.register(normalUser);
//            // Додавання користувача до очікуваного стану бази даних
//            expectedDbState.add(normalUser);
//        }
//        // Перевірка, що всі користувачі мають ідентифікатори після реєстрації
//        for (User user : expectedDbState) {
//            assertNotNull(user.getId(), "User must have id after registration");
//        }
//        // Перевірка стану бази даних
//        assertEquals(Storage.people, expectedDbState, "Unexpected database state");
//    }

    /**
     * Тест на реєстрацію користувача з вказаним ID.
     * Перевіряє, чи користувач був зареєстрований успішно та чи був він збережений у базі даних.
     */
//    @Test
//    void register_withId_ok() {
//        // Створення користувача з вказаним ідентифікатором
//        User user = createUser(-1L, DEFAULT_LOGIN, VALID_PASSWORD, MIN_USER_AGE);
//        // Реєстрація користувача
//        registrationService.register(user);
//        // Очікуваний стан бази даних
//        List<User> expectedDbState = new ArrayList<>();
//        expectedDbState.add(user);
//        // Перевірка, що користувач був збережений у базі даних
//        assertEquals(Storage.people, expectedDbState, "User must be saved in db");
//    }

    /**
     * Метод {@code register_sameLogin_notOk} тестує реєстрацію користувача з вже існуючим логіном.
     * Перевіряється виникнення винятку {@code UserRegistrationException} та правильність стану бази даних
     * після спроби реєстрації користувача з вже існуючим логіном.
     */
//    @Test
//    void register_sameLogin_notOk() {
//        // Створення першого користувача з унікальним логіном
//        User normalUser1 = createUser(DEFAULT_LOGIN, VALID_PASSWORD, MIN_USER_AGE);
//        // Створення другого користувача з тим самим логіном, але з іншими даними
//        User normalUser2 = createUser(DEFAULT_LOGIN, VALID_PASSWORD + VALID_PASSWORD, MIN_USER_AGE * 2);
//        // Реєстрація першого користувача
//        registrationService.register(normalUser1);
//        // Перевірка, що при спробі реєстрації другого користувача з вже існуючим логіном
//        // виникає виняток UserRegistrationException
//        assertThrows(UserRegistrationException.class, () -> registrationService.register(normalUser2));
//        // Очікуваний стан бази даних - містить тільки першого користувача
//        List<User> expectedDbState = new ArrayList<>();
//        expectedDbState.add(normalUser1);
//        // Перевірка стану бази даних
//        assertEquals(Storage.people, expectedDbState, "Only first user must be saved in db");
//    }

    /**
     * Метод {@code register_userTooYoung_notOk} тестує реєстрацію надто молодого користувача.
     * Перевіряється виникнення винятку {@code UserRegistrationException} та правильність стану бази даних
     * після спроби реєстрації надто молодого користувача.
     */
//    @Test
//    void register_userTooYoung_notOk() {
//        // Створення користувача з надто молодим віком
//        User youngUser = createUser(DEFAULT_LOGIN, VALID_PASSWORD, MIN_USER_AGE - 1);
//        // Перевірка, що при спробі реєстрації надто молодого користувача виникає виняток UserRegistrationException
//        assertThrows(UserRegistrationException.class, () -> registrationService.register(youngUser));
//        // Очікуваний стан бази даних - порожній, користувач не повинен бути збережений
//        List<User> expectedDbState = new ArrayList<>();
//        // Перевірка стану бази даних
//        assertEquals(Storage.people, expectedDbState, "User mustn't be saved");
//    }

    /**
     * Метод {@code register_nullFields_notOk} тестує реєстрацію користувача з нульовими полями.
     * Перевіряється виникнення винятку {@code UserRegistrationException} та правильність стану бази даних
     * після спроби реєстрації користувача з нульовими полями.
     */
//    @Test
//    void register_insecurePassword_notOk() {
//        // Створення користувача з небезпечним паролем (порожній пароль)
//        User user = createUser(DEFAULT_LOGIN, "", MIN_USER_AGE);
//        // Перевірка, що при спробі реєстрації користувача з небезпечним паролем виникає виняток PasswordException
//        assertThrows(PasswordException.class, () -> registrationService.register(user));
//        // Очікуваний стан бази даних - порожній, користувач не повинен бути збережений
//        List<User> expectedDbState = new ArrayList<>();
//        // Перевірка стану бази даних
//        assertEquals(Storage.people, expectedDbState, "User mustn't be saved");
//    }

    /**
     * Тест на реєстрацію користувача з нульовими полями.
     * Перевіряє, чи виникає виняток UserRegistrationException під час реєстрації користувача з нульовими полями,
     * та чи не зберігається користувач у базі даних.
     */
//    @Test
//    void register_nullFields_notOk() {
//        // Створення користувача з нульовими полями
//        User user = createUser(null, null, null);
//        // Перевірка, що при спробі реєстрації користувача з нульовими полями виникає виняток UserRegistrationException
//        assertThrows(UserRegistrationException.class, () -> registrationService.register(user));
//        // Очікуваний стан бази даних - порожній, користувач не повинен бути збережений
//        List<User> expectedDbState = new ArrayList<>();
//        // Перевірка стану бази даних
//        assertEquals(Storage.people, expectedDbState, "User mustn't be saved");
//    }

    /**
     * Метод {@code register_null_notOk} тестує реєстрацію з нульовим користувачем.
     * Перевіряється виникнення винятку {@code UserRegistrationException} при спробі реєстрації нульового користувача.
     */
//    @Test
//    void register_null_notOk() {
//        // Перевірка, що при спробі реєстрації нульового користувача виникає виняток UserRegistrationException
//        assertThrows(UserRegistrationException.class, () -> registrationService.register(null));
//    }

    /**
     * Приватний метод {@code createUser} використовується для створення об'єкту користувача з заданими параметрами.
     * Метод приймає значення для логіну, пароля та віку користувача і створює об'єкт типу User з цими значеннями.
     * Якщо необхідно, можна також вказати ідентифікатор користувача.
     * Повертає створений об'єкт користувача.
     *
     * @param login    логін користувача
     * @param password пароль користувача
     * @param age      вік користувача
     * @return об'єкт користувача з заданими параметрами
     */
//    private User createUser(String login, String password, Integer age) {
//        return createUser(null, login, password, age);
//    }

    /**
     * Приватний метод {@code createUser} використовується для створення об'єкту користувача з заданими параметрами.
     * Метод приймає значення для ідентифікатора, логіну, пароля та віку користувача і створює об'єкт типу User з цими
     * значеннями. Повертає створений об'єкт користувача.
     *
     * @param id       ідентифікатор користувача
     * @param login    логін користувача
     * @param password пароль користувача
     * @param age      вік користувача
     * @return об'єкт користувача з заданими параметрами
     */
//    private User createUser(Long id, String login, String password, Integer age) {
//        User user = new User();
//        user.setId(id);
//        user.setLogin(login);
//        user.setPassword(password);
//        user.setAge(age);
//        return user;
//    }
}
