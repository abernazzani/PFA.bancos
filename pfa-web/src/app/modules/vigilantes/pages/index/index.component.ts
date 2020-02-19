import { Component, OnInit } from '@angular/core';
import { Vigilante } from 'src/app/core/models/vigilante';
import { VigilantesService } from 'src/app/core/services/api/vigilantes.service';
import { VigilantesEditComponent } from '../edit/edit.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';

@Component({
    selector: 'vigilantes-index',
    templateUrl: 'index.component.html'
})

export class VigilantesIndexComponent implements OnInit {
    vigilantes: Vigilante[];

    constructor(private vigilantesService: VigilantesService,
        private modalService: NgbModal) { }

    async ngOnInit() {
        this.getAll();
    }

    async getAll() {
        debugger;
        this.vigilantes = await this.vigilantesService.getAll();
    }

    async edit(vigilante: Vigilante) {
        const modalRef = this.modalService.open(VigilantesEditComponent);

        if (vigilante) {
            modalRef.componentInstance.codigo = vigilante.codigo;
        }

        var result = await modalRef.result;
        debugger;
        if (result == ModalResult.Ok) {
            this.getAll();
        }
    }

    async delete($event, vigilante: Vigilante) {
        await this.vigilantesService.delete(vigilante.nombre);
        this.getAll();
        $event.stopPropagation();
    }
}