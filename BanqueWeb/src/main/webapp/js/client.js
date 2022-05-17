function deleteClient(cin) {
	swal({
		title: "Are you sure?",
		text: "Once deleted, you will not be able to recover this client!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {
				$.ajax({
					url: "ClientController",
					type: "POST",
					data: {
						action: "delete",
						cin: cin
					},
					success: function() {
						$("#" + cin).remove();
						swal("the client has been deleted!", {
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