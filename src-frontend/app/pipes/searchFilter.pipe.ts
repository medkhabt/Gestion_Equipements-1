import { PipeTransform, Pipe } from '@angular/core';

@Pipe({
    name: 'SearchEtatFilter',
    pure: false
})
export class SearchFilter implements PipeTransform {
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
            reservation.etat.indexOf(searchSubject) !== -1
        );
    }
}
