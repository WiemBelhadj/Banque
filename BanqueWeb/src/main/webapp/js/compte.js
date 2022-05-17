function deleteCompte(rib) {
	swal({
		title: "Are you sure?",
		text: "Once deleted, you will not be able to recover this account!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {
				$.ajax({
					url: "CompteController",
					type: "POST",
					data: {
						action: "delete",
						rib: rib
					},
					success: function() {
						$("#" + rib).remove();
						swal("Your Compte has been deleted!", {
							icon: "success",
						});
					},
					error: function() {
						swal("Poof! server error!", {
							icon: "error",
						});
					}
				});
			}
		});
}