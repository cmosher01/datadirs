package nu.mine.mosher.io;

import dev.dirs.*;

import java.util.Optional;
import org.apache.commons.io.FileUtils;

import static java.lang.System.out;

public class DataDirs {
    public static void main(final String... args) {
        out.println("PROJECT");
        final var proj = ProjectDirectories.from("nu.mine.mosher", "<org>", "<app>");
        print(proj.preferenceDir, "prefs");
        print(proj.configDir, "config");
        print(proj.dataDir, "data");
        print(proj.dataLocalDir, "local data");
        print(proj.cacheDir, "cache");

        out.println();

        out.println("BASE");
        final var base = BaseDirectories.get();
        print(base.preferenceDir, "prefs");
        print(base.configDir, "config");
        print(base.dataDir, "data");
        print(base.dataLocalDir, "local data");
        print(base.cacheDir, "cache");

        out.println();

        out.println("USER");
        final var user = UserDirectories.get();
        print(user.homeDir, "home");
        print(user.documentDir, "documents");
        print(user.templateDir, "templates");

        out.println();

        out.println("ENVIRONMENT VARIABLES");
        printEnv("HOME");
        printEnv("USERPROFILE");
        printEnv("HOMEDRIVE");
        printEnv("HOMEPATH");
        printEnv("USER");
        printEnv("USERNAME");
        printEnv("XDG_DATA_HOME");
        printEnv("APPDATA");
        printEnv("LOCALAPPDATA");
        printEnv("XDG_CONFIG_HOME");
        printEnv("XDG_STATE_HOME");
        printEnv("XDG_CACHE_HOME");
        printEnv("XDG_BIN_HOME");
        printEnv("ProgramData");
        printEnv("XDG_DATA_DIRS");
        printEnv("XDG_CONFIG_DIRS");
        printEnv("XDG_RUNTIME_DIR");

        out.println();

        out.println("OTHER");
        print(FileUtils.getUserDirectoryPath(), "Commons I/O home");
        print(System.getProperty("user.home", "<undefined>"), "sysprop: user.home");
    }

    private static void print(final String dir, final String name) {
        out.printf("%20s: %s\n", name, dir);
    }

    private static void printEnv(final String env) {
        print(Optional.ofNullable(System.getenv(env)).orElse("<undefined>"), env);
    }
}
