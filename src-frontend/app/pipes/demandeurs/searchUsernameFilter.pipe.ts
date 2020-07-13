import { PipeTransform, Pipe } from '@angular/core';

@Pipe({
    name: 'SearchUsernameFilter',
    pure: false
})
export class SearchUsernameFilter implements PipeTransform {
    transform(demandeurs: any, searchSubject: string): any {
        if (!demandeurs || !searchSubject) {
            console.log('viiiiide!!!');
            return demandeurs;
        }
        console.log('probleeeme!!!');
        console.log(demandeurs.filter(demandeur =>
            demandeur.username.indexOf(searchSubject)
        ));
        return demandeurs.filter(demandeur =>
            demandeur.username.indexOf(searchSubject) !== -1
        );
    }
}
