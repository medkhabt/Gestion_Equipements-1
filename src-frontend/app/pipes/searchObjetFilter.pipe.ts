import { PipeTransform, Pipe } from '@angular/core';

@Pipe({
    name: 'SearchObjetFilter',
    pure: false
})
export class SearchObjetFilter implements PipeTransform {
    transform(reservations: any, searchSubject: string): any {
        if (!reservations || !searchSubject) {
            console.log('viiiiide!!!');
            return reservations;
        }
        console.log('probleeeme!!!');
        console.log(reservations.filter(reservation =>
            reservation.etat.indexOf(searchSubject)
        ));
        return reservations.filter(reservation =>
            reservation.demande.objet.indexOf(searchSubject) !== -1
        );
    }
}
