import com.company.project.*

class BootStrap {

    def init = { servletContext ->
        [ new BookMarshaller() ].each { it.register() }
		Book bookIt = null;
		for (int i = 0 ; i < 20 ;i++){
			bookIt = new Book(title: 'Book '+i, isbn: '123'+i).save()
		}
//        def book1 = new Book(title: 'Book 1', isbn: '123').save()
//        def book2 = new Book(title: 'Book 2', isbn: '456').save()
		

    }
    def destroy = {
    }
}
