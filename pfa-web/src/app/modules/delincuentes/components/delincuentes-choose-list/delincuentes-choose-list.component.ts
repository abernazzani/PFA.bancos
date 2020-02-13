import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { Delincuente } from 'src/app/core/models/delincuente';
import { DelincuentesService } from 'src/app/core/services/api/delincuentes.service';

@Component({
    selector: 'delincuentes-choose-list',
    templateUrl: 'delincuentes-choose-list.component.html'
})

export class DelincuentesChooseListComponent implements OnInit {
    delincuentes: Delincuente[];

    @Output()
    cancelled: EventEmitter<void> = new EventEmitter();

    @Output()
    accepted: EventEmitter<Delincuente[]> = new EventEmitter();

    @Output()
    itemsChanged: EventEmitter<Delincuente[]> = new EventEmitter();

    @Input()
    selectedDelincuentes: Delincuente[];

    @Input()
    showButtons: boolean = true;

    constructor(private delincuentesService: DelincuentesService) {

    }

    async ngOnInit() {
        this.delincuentes = await this.delincuentesService.getAll();
        if (!this.selectedDelincuentes) {
            this.selectedDelincuentes = new Array<Delincuente>();
        }
    }

    getIfSelected(delincuente: Delincuente) {
        return this.selectedDelincuentes.some(x => x.codigo == delincuente.codigo);
    }

    selectedChanged(delincuente: Delincuente) {
        if (this.getIfSelected(delincuente)) {
            let selectedDelincuenteIndex = this.selectedDelincuentes.findIndex(x => x.codigo == delincuente.codigo);
            this.selectedDelincuentes.splice(selectedDelincuenteIndex, 1);
        } else {
            this.selectedDelincuentes.push(delincuente);
        }
        this.itemsChanged.next(this.selectedDelincuentes);
    }

    accept() {
        console.log(this.selectedDelincuentes);
        this.accepted.next(this.selectedDelincuentes);
    }

    cancel() {
        this.cancelled.next();
    }
}