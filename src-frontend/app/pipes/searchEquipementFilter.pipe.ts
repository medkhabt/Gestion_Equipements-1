import { PipeTransform, Pipe } from '@angular/core';

@Pipe({
    name: 'SearchEquipementFilter',
    pure: false
})
export class SearchEquipementFilter implements PipeTransform {
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
            reservation.equipement.nom.indexOf(searchSubject) !== -1
        );
    }
}
