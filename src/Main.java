// Интерфейс для отчетов
interface IReport {
    // Метод для генерации данных отчета
    String generate();
}

// Класс отчета по продажам, который реализует IReport
class SalesReport implements IReport {
    @Override
    public String generate() {
        // Возвращает данные отчета по продажам
        return "Sales Report Data";
    }
}

// Класс отчета по пользователям, который реализует IReport
class UserReport implements IReport {
    @Override
    public String generate() {
        // Возвращает данные отчета по пользователям
        return "User Report Data";
    }
}

// Абстрактный класс декоратора для отчетов
abstract class ReportDecorator implements IReport {
    // Ссылка на исходный отчет, к которому добавляются новые функции
    protected IReport report;

    // Конструктор принимает отчет для декорирования
    public ReportDecorator(IReport report) {
        this.report = report;
    }

    @Override
    public String generate() {
        // Вызывает метод generate() базового отчета
        return report.generate();
    }
}

// Декоратор для фильтрации отчета по дате
class DateFilterDecorator extends ReportDecorator {
    public DateFilterDecorator(IReport report) {
        super(report);
    }

    @Override
    public String generate() {
        // Добавляет текст "with Date Filter" к данным отчета
        return super.generate() + " with Date Filter";
    }
}

// Декоратор для сортировки данных отчета
class SortingDecorator extends ReportDecorator {
    public SortingDecorator(IReport report) {
        super(report);
    }

    @Override
    public String generate() {
        // Добавляет текст "with Sorting" к данным отчета
        return super.generate() + " with Sorting";
    }
}

// Декоратор для экспорта отчета в формат CSV
class CsvExportDecorator extends ReportDecorator {
    public CsvExportDecorator(IReport report) {
        super(report);
    }

    @Override
    public String generate() {
        // Добавляет текст "Exported as CSV" к данным отчета
        return super.generate() + " Exported as CSV";
    }
}

// Декоратор для экспорта отчета в формат PDF
class PdfExportDecorator extends ReportDecorator {
    public PdfExportDecorator(IReport report) {
        super(report);
    }

    @Override
    public String generate() {
        // Добавляет текст "Exported as PDF" к данным отчета
        return super.generate() + " Exported as PDF";
    }
}

// Основной класс с клиентским кодом
public class Main {
    public static void main(String[] args) {
        // Создаем отчет по продажам
        IReport report = new SalesReport();

        // Последовательно добавляем декораторы: фильтр по дате, сортировку и экспорт в PDF
        report = new DateFilterDecorator(report);
        report = new SortingDecorator(report);
        report = new PdfExportDecorator(report);

        // Выводим результат, включающий все примененные декорации
        System.out.println(report.generate());
    }
}
