import { Component, OnInit } from '@angular/core';
import { Delincuente } from 'src/app/core/models/delincuente';
import { DelincuentesService } from 'src/app/core/services/api/delincuentes.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { DelincuentesEditComponent } from '../edit/edit.component';
import { DelincuentesChooseListComponent } from '../../components/delincuentes-choose-list/delincuentes-choose-list.component';
import { AuthService } from 'src/app/core/services/api/auth.service';

@Component({
    selector: 'delincuentes-index',
    templateUrl: 'index.component.html'
})

export class DelincuentesIndexComponent implements OnInit {
    delincuentes: Delincuente[];

    constructor(private delincuentesService: DelincuentesService,
        private modalService: NgbModal,public authService: AuthService) {
    }

    async ngOnInit() {
        this.getAll();
    }

    async getAll() {
        this.delincuentes = await this.delincuentesService.getAll();
    }

    async edit(delincuente: Delincuente = null) {
        debugger;
        const modalRef = this.modalService.open(DelincuentesEditComponent);

        if (delincuente) {
            modalRef.componentInstance.codigo = delincuente.codigo;
        }

        var result = await modalRef.result;
        debugger;
        if (result == ModalResult.Ok) {
            this.getAll();
        }
    }

    async delete($event, delincuente: Delincuente) {
        debugger;
        await this.delincuentesService.delete(delincuente.codigo);
        this.getAll();
        $event.stopPropagation();
    }
}