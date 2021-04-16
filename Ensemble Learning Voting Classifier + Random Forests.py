from sklearn import datasets
from sklearn.ensemble import RandomForestClassifier
from sklearn.ensemble import VotingClassifier
from sklearn.svm import SVC
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score
from sklearn.model_selection import train_test_split
from sklearn.model_selection import cross_val_score

data = datasets.load_iris()

X = data['data'][:, 2:]
y = data['target']

clf_svm = SVC(probability=True)
clf_log = LogisticRegression()
clf_rnd = RandomForestClassifier()

X_train, X_test, y_train, y_test = train_test_split(X, y)


clf_voting = VotingClassifier(estimators=[('lr', clf_log), ('rf', clf_rnd), ('svc', clf_svm)], voting='soft')


for clf in (clf_log, clf_rnd, clf_svm, clf_voting):
	clf.fit(X_train, y_train)
	y_pred = clf.predict(X_test)
	print(clf.__class__.__name__, accuracy_score(y_test, y_pred))

