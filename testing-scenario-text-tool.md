# Тестовое задание Realtime Board

## Задание 1

_Проверка навыков "ручного" тестирования._

Написать тестовый сценарий проверяющий функционал инструмента **Text** в сервисе RealtimeBoard.

Требования к сценарию:

* Сценарий должен содержать всевозможный набор действий, которые можно применять к этому инструменту, включая совместную работу нескольких пользователей, использующих этот инструмент на доске.
* Сценарий должен быть легко читаемым, понятным, избегать повторяющихся действий, обладать хорошим покрытием.
* Если будут найдены какие то ситуации, которые будут казаться некорректными, то их следует описывать примечанием в конце сценария.

##Выполнение задания

###TestID - 0001

###Name -- Проверка инструмента **Text**

###Предварительные шаги

1. Залогинится в систему.
2. Создать новую доску или открыть любую существующую, доступную для редактирования.

###Тестовый сценарий
1. Проверить наличие инструмента **Text** на панели инструментов (далее, тулбаре).
2. Создать новый текст на доске с помощью инструмента **Text** на тулбаре.
	* с помощью клика на иконку инструмента **Text** на тулбаре и клика на нужном (произвольном) месте доски;
	* вызовом команды **add text** из контекстного меню;
	* с помощью клавиатуры и клика на нужном (произвольном) месте доски:
		* клавиша **T**;
		* клавиша **2**.
3. Ввести любой текст в поле:
	* однострочный;
	* многострочный;
	* проверить, что лимит на количество символов - 2000 (Невозможно ввести больше 2000 символов в текстовый блок, должно появится всплывающее сообщение вверху страницы:
	
	> Sorry, you can't paste more than 2000 characters into Text box.
	
	* проверить, что при различном масштабировании доски, шрифта по умолчанию разного размера (при максимальном приближении - 4, при максимальном удалении - до 7000 (зависит от общих размеров доски));
	* проверить копирование и вставку текста с помощью **Ctrl+C/Ctrl+V** или **⌘+C/⌘+V**.
4. Кликом на любое место доски выйти из режима редактирования.
5. Нажать клавишу **T** (**2**) или выбрать инструмент **text** в тулбаре и кликом на текстовом блоке войти в режим редактирования текста. Повторить с помощью инструмента **select** (клавиша **V** или **2**) и двойного клика на текстовом блоке.
6. Отредактировать текст.
7. Изменить размер шрифта в текстовом блоке с помощью:
	* всплывающего тулбара (стрелками и вводом цифрового значения с клавиатуры);
	* с помощью курсора перетягиванием за угол текстового блога.
8. Проверить работу инструментов изменения форматирования текста и их комбинации:
	* **bold**;
	* *italic*;
	* <u>underline</u>;
	* <span style="color:blue">измение</span> <span style="color:red">цвета</span> <span style="color:green">текста</span>.
9. Создать ссылки на произвольную страницу с помощью инструмента **add url**:
	* с любого текста из текстового блока;
	* с текстового блока целиком.
10. Перейти по созданным ссылкам.
11. Выравнять текст по левому краю, по центру и по правому краю с помощью **align text**.
12. Создать маркированный список с помощью инструмента **bulleted list** или установки знака **-** в начале строки, убедиться, что в новые строки в списке появляются при перевде курсора на новую строку. 
13. Создать нумерованный список, убедится в автоматическом проставлении номера в новых строках.
14. Залить текстовый блок разными цветами с помощью инструмента **fill color**.
15. В дополнительном меню всплывающего тулбара выбрать **Copy link**.
16. Открыть в новой вкладке, скопированный url, удедится, что по центру страницы нужный текстовый блок.
17. Создать ссылку с одного текстового блока на другой используя **Copy link** и **Link to**.
18. Убедиться, что работает переход от одного текстового блока к другому по созданной ссылке.
19. Закрыть на редактирование текстовый блок с помощью инструмента **Lock** и убедится, что текстовый блок невозможно отредактировать.
20. Открыть на редактирование этот текстовый блок с помощью инструмента **Unlock** и убедится, что текстовый блок можно редактировать.
21. Создать несколько (3-4) текстовых блоков или других объектов на доске с наложением друг на друга. Убедится, что работают инструменты **Bring forward** и **Send backward**
22. Скопировать и вставить любой текстовый блок с помощью стандартных горячих клавиш (**Ctrl+C/Ctrl+V** или **⌘+C/⌘+V**).
23. Создать дубликат любого текстового блока с помощью инструмента **Duplicate** или клавиш **Ctrl+D** (**⌘+D**).
24. Экспортировать содержимое текстового блока в CSV (только для Chrome и Firefox).
25. Удалить любой текстовый блок с помощью клавиатуры (Delete или Backspace) и с помощью Delete из меню.
26. Открыть в другом браузере эту же доску под другим пользователем и отрыть любой тестовый блок на редактирование. Убедится, что другой пользоватьель не может редактировать этот же текстовый блок.
27. Отредактровать текст и выйти из режима редатирования, убедится, что отредактированный вариант виден другому пользователю.