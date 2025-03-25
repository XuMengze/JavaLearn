package com.alg.systemdesign;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class PasswordManager {
    private final int satisfyContainNumber = 1;
    private final String START_WITH_UPPERCASE = "[A-Z]+.*";
    private final String CONTAIN_UPPERCASE = ".*[A-Z]+.*";
    private final String CONTAIN_LOWERCASE = ".*[a-z]+.*";
    private final String CONTAIN_DIGIT = ".*[0-9]+.*";
    private final String CONTAIN_SPECIAL_CHARACTER = ".*[\\.\\*()!@#$%^&]+.*";
    private final int CONTAIN_MUST_SATISFY = 3;
    private final int CONTAIN_LENGTH = 5;
    private final Map<String, List<Password>> PasswordDao;

    public PasswordManager(Map<String, List<Password>> passwordDao, List<StrategyCollection> strategyCollection) {
        PasswordDao = passwordDao;
        this.strategyCollection = strategyCollection;
    }

    private final List<StrategyCollection> strategyCollection;

    public ReturnResult check(String username, String inputPassword) {
        if (inputPassword == null || "".equals(inputPassword)) {
            return new ReturnResult(Level.empty, null);
        }
        List<CheckResult> r = strategyCollection.stream().map(strategyCollection -> {
                    List<Strategy> failed = new java.util.ArrayList<>(List.of());
                    AtomicInteger passed = new AtomicInteger();
                    AtomicInteger score = new AtomicInteger();
                    strategyCollection.strategies.stream().peek(
                            strategy -> {
                                switch (strategy) {
                                    case length -> {
                                        boolean pass = checkLength(inputPassword);
                                        if (pass) {
                                            score.addAndGet(Strategy.length.getScore());
                                            passed.getAndIncrement();
                                        } else {
                                            failed.add(Strategy.length);
                                        }
                                    }
                                    case containDigit -> {
                                        boolean pass = checkContainDigit(inputPassword);
                                        if (pass) {
                                            score.addAndGet(Strategy.length.getScore());
                                            passed.getAndIncrement();
                                        } else {
                                            failed.add(Strategy.length);
                                        }
                                    }
                                    default -> throw new RuntimeException("");
                                }
                            });
                    if (passed.get() >= strategyCollection.passIfHowManyStrategyPass) {
                        return new CheckResult(true, score.get(), null);
                    } else {
                        return new CheckResult(false, 0, new StrategyCollection(strategyCollection.passIfHowManyStrategyPass, failed));
                    }
                }

        ).toList();
        r.stream().mapToInt(CheckResult::getScore).sum();
        return new ReturnResult(Level.getLevel(r.stream().mapToInt(CheckResult::getScore).sum()),
                r.stream().map(CheckResult::getFailed).toList());
    }

    private boolean checkLength(String inputPassword) {
        return inputPassword.length() >= CONTAIN_LENGTH;
    }

    private boolean checkStartWithUppercase(String inputPassword) {
        return inputPassword.matches(START_WITH_UPPERCASE);
    }

    private boolean checkContainUppercase(String inputPassword) {
        return inputPassword.matches(CONTAIN_UPPERCASE);
    }

    private boolean checkContainLowercase(String inputPassword) {
        return inputPassword.matches(CONTAIN_LOWERCASE);
    }

    private boolean checkContainDigit(String inputPassword) {
        return inputPassword.matches(CONTAIN_DIGIT);
    }

    private boolean checkContainSpecialCharacter(String inputPassword) {
        return inputPassword.matches(CONTAIN_SPECIAL_CHARACTER);
    }

    private boolean checkNoRepeatWithPrevious(String username, String inputPassword, int times) {
        return PasswordDao.get(username).stream().map(Password::getPassword).filter(s -> s.equals(inputPassword)).toList().size() >= times;
    }

    private static class Password {
        long id;
        String userid;
        String password; // encrypt
        Date createdAt;

        public String getPassword() {
            return password;
        }
    }

    private static class StrategyCollection {
        int passIfHowManyStrategyPass;
        List<Strategy> strategies;

        public StrategyCollection(int passIfHowManyStrategyPass, List<Strategy> strategies) {
            this.passIfHowManyStrategyPass = passIfHowManyStrategyPass;
            this.strategies = strategies;
        }
    }

    private static class CheckResult {
        boolean passed;
        int score;
        StrategyCollection failed;

        public CheckResult(boolean passed, int score, StrategyCollection failed) {
            this.passed = passed;
            this.score = score;
            this.failed = failed;
        }

        public int getScore() {
            return score;
        }

        public StrategyCollection getFailed() {
            return failed;
        }
    }

    private static class ReturnResult {
        Level level;
        List<StrategyCollection> failed;

        public ReturnResult(Level level, List<StrategyCollection> failed) {
            this.level = level;
            this.failed = failed;
        }
    }
}

enum Level {
    strong, medium, weak, veryWeak, empty;

    static Level getLevel(int score) {
        if (score >= 6) {
            return strong;
        } else if (score >= 4) {
            return medium;
        } else if (score >= 2) {
            return weak;
        } else {
            return veryWeak;
        }

    }
}

enum Strategy {
    length(2), startWithUppercase(2), containUppercase(1), containDigit(1), containLowercase(1), noRepeatWithPrevious(1), containSpecialCharacter(1);
    private final int score;

    Strategy(int score) {
        this.score = score;
    }

    int getScore() {
        return this.score;
    }
}
