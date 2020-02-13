
import { Component, OnInit } from '@angular/core';
import { Banda } from 'src/app/core/models/banda';
import { BandasService } from 'src/app/core/services/api/bandas.service';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { Vigilante } from 'src/app/core/models/vigilante';
import { VigilantesService } from 'src/app/core/services/api/vigilantes.service';
import { VigilantesEditComponent } from '../edit/edit.component';

@Component({
    selector: 'bandas-index',
    templateUrl: 'index.component.html'
})

export class VigilantesIndexComponent implements OnInit {
    vigilantes: Vigilante[];

    constructor(private vigilantesService: VigilantesService,
        private modalService: NgbModal) {
    }

    async ngOnInit() {
        this.getAll();
    }

    async getAll() {
        this.vigilantes = await this.vigilantesService.getAll();
    }

    async edit(vigilante: Vigilante) {
        const modalRef = this.modalService.open(VigilantesEditComponent);

        if (vigilante) {
            modalRef.componentInstance.nombre = vigilante.nombre;
        }

        var result = await modalRef.result;
        debugger;
        if (result == ModalResult.Ok) {
            this.getAll();
        }
    }

    async delete($event, vigilante: Vigilante) {
        debugger;
        await this.vigilantesService.delete(vigilante.codigo);
        this.getAll();
        $event.stopPropagation();
    }
}